// Copyright 2025 Aniket

#include <assert.h>
#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

void push(int value);
int pop();
int peek();
bool isEmpty();
int size();
void resize_array(int new_capacity);

int *array;
int N = 0;
int max_size = 1;

void resize_array(int new_capacity) {
  int *new_array = (int *)malloc(sizeof(int) * new_capacity);

  for (int i = 0; i < N; i++) {
    new_array[i] = array[i];
  }
  free(array);
  array = new_array;
  max_size = new_capacity;
}

void push(int item) {
  if (N >= max_size) {
    resize_array(max_size * 2);
  }
  array[N++] = item;
}

int peek() {
  if (isEmpty()) {
    fprintf(stderr, "Error: empty stack\n");
    exit(EXIT_FAILURE);
  }
  return array[N - 1];
}

int pop() {
  if (isEmpty()) {
    fprintf(stderr, "Error: Stack Underflow\n");
    exit(EXIT_FAILURE);
  }
  int item = array[--N];
  if (N > 0 && N <= max_size / 4) {
    max_size /= 2;
    if (max_size == 0) max_size = 1;
    resize_array(max_size);
  }
  return item;
}

bool isEmpty() { return N == 0; }

int size() { return N; }

void testStack() {
  push(10);
  push(20);
  push(30);

  assert(size() == 3);
  assert(isEmpty() == false);

  assert(peek() == 30);
  assert(size() == 3);

  assert(pop() == 30);
  assert(size() == 2);
  assert(peek() == 20);

  assert(pop() == 20);
  assert(size() == 1);
  assert(peek() == 10);

  assert(pop() == 10);
  assert(size() == 0);
  assert(isEmpty() == true);

  printf("All stack tests passed!\n");
}

int main() {
  array = (int *)malloc(sizeof(int) * max_size);
  testStack();
  free(array);
  return 0;
}
