// JavaScript is a single-threaded, object-oriented scripting language.

function foo(param1) {
    // Hoisting is a feature of JS where it moves the declaration (not the initialization)
    // of a variable to the top-level scope of the function.
    // var x; --> is hoisted here implicitly.

    if (param1) {
        console.log(param1);
    } else {
        console.log("Hello World!", document.getElementById("tag1")?.innerHTML);
        // document.getElementById("tag1")?.innerHTML:
        // The optional chaining operator (?) checks if the element exists.
        // If it doesn't, it safely returns undefined.
    }

    if (document.getElementById("tag1")) {
        var x = 20; // Declaration is hoisted; initialization happens here.
        document.getElementById("tag1").innerHTML = "Hello World from JavaScript!";
    }

    // ❌ Incorrect:
    // document.getElementById("tag1")?.innerHTML = "Hello World from JavaScript!";
    // Optional chaining (?) cannot be used on the left-hand side of an assignment.
}

// Example of delayed execution using setTimeout
// setTimeout(() => {
//     console.log("This is a delayed message.");
// }, 2000);

// You can also call foo after a delay
// setTimeout(foo, 2000, "Hello World from setTimeout");
// This delays execution of foo by 2 seconds with "Hello World from setTimeout" as an argument.


// Global product list
var productsList = [];

function loadProducts(renderProductsListWithData) {
    setTimeout(() => {
        productsList = productsListfromServer
        renderProductsListWithData()
    }, 2000);
}

// Template literals (``) allow multi-line strings and embedding expressions using ${}
// Initially designed for HTML templates and clean string interpolation.

// Delay loading of products (non-blocking)
// setTimeout(loadProducts, 2000);

// Explanation of setTimeout() event loop behavior:
// 1. setTimeout() is called.
// 2. The callback is registered with the browser’s timer system.
// 3. After the delay, it is placed in the task queue.
// 4. Once the call stack is empty, the event loop moves the callback to the call stack.
// 5. Callback finally runs.

var arr = [1, 2, 4, 8, 16]
function renderProducts() {
    // document.getElementById("tag2").innerHTML = arr;
    // Normally you'd fetch data from a server here
    // Then convert the data into HTML and render into UI

    function renderProductsListWithData() {
        if (productsList.length === 0) {
            document.getElementById("data").innerHTML = "Loading data from server...";
            return;
        }

        document.getElementById("data").innerHTML = `
            <table border="1" cellpadding="10">
                <thead>
                    <tr>
                        <th>Sr. No.</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    ${productsList.map((product, index) => {
                        return `
                            <tr>
                                <td>${index + 1}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.desc}</td>
                            </tr>
                        `;
                    }).join("")}
                </tbody>
            </table>
        `;
    }

    loadProducts(renderProductsListWithData);
    renderProductsListWithData();
}

// Call the function to render products
renderProducts();

const foo1 = (arg1) => {
    console.log(arg1);
}

function foo2(arg1) {
    console.log(arg1);
}
// () => {} are arrow functions, also called anonymous functions
// because they don't require a name and are often used for concise function expressions.
// A callback function is any function which is passed as an argument to another function.