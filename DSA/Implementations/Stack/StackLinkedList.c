// Copyright 2025 Aniket

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <stdbool.h>

struct Node {
  int item;
  struct Node*next;
};

struct Node* head = NULL;
int N = 0;

bool isEmpty() {
  return head == NULL;
}

int size() {
  return N;
}

void push(int value) {
  struct Node* oldHead = head;
  head = (struct Node*) malloc(sizeof(struct Node));
  head->item = value;
  head->next = oldHead;
  N++;
}

int pop() {
  if (isEmpty()) {
    fprintf(stderr, "Error: empty stack\n");
    exit(EXIT_FAILURE);
  }
  struct Node* temp = head;
  int item = temp->item;
  head = head->next;
  N--;
  free(temp);

  return item;
}

int peek() {
  if (isEmpty()) {
    fprintf(stderr, "Error: empty stack\n");
    exit(EXIT_FAILURE);
  }
  return head->item;
}

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
  testStack();
  return 0;
}
