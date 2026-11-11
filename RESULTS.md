# UI lab results

Tool parts that I chose: Part 2 (Selenium WebDriver in Java) and Part 4 (Cypress)

## Part 0
- Step 0.1, Chrome version: Google Chrome 157.0.8103.51 (arm64)
- Step 0.3, ChromeDriver version: ChromeDriver 157.0.8103.51
- Step 0.4, locator of Pizza, Please!: `button[name="pizza-please"]` (1 match)
- Step 0.4, locator of Excluded tools: `select[multiple]` (1 match)
- Step 0.4, locator of Must be vegetarian: `#default-checkbox` (1 match)
- Step 0.4, locator of Custom Pizza Name: `input#pizza-name` (1 match; `#pizza-name` alone matches 2 after the answer appears)
- Step 0.5, pizza name, tool and calories of the run by hand: Lab Pizza 20261111-082800, Pizza cutter, 400 calories per slice

| Step | Actual result | Pass or fail |
|------|---------------|--------------|
| 1 | Heading read "Looking to break out of your pizza routine?" | Pass |
| 2 | Max Calories per Slice (1000), Excluded tools (Knife, Pizza cutter, Scissors), Must be vegetarian and Custom Pizza Name appeared | Pass |
| 3 | Calories 600, Knife selected, vegetarian ticked, name Lab Pizza 20261111-082800 | Pass |
| 4 | Name: Lab Pizza 20261111-082800, Tool: Pizza cutter, Calories per slice: 400 | Pass |
| 5 | Page said "Please log in first." | Pass |
| 6 | Boxes prefilled with admin; after Sign in the page showed "Latest pizza recommendations" | Pass |
| 7 | Line: Lab Pizza 20261111-082800 (tool=Pizza cutter, ingredients_number=7) | Pass |

## Part 2: Selenium WebDriver in Java
- Step 2.4, the failure line for the wrong title: `[ERROR]   FirstTest.webFormOpens:20 expected: <Web Form> but was: <Web form>`
- Step 2.15, QP01Test run 1, result and time:
- Step 2.15, QP01Test run 2, result and time:
- Step 2.20, full run 1, time and number of tests:
- Step 2.20, full run 2, time and number of tests:

## Part 4: Cypress
- node --version, npm --version and npx cypress version:
- Step 4.3, failure message for the wrong title:
- Step 4.6, tool and calories in the answer of POST /api/pizza:
- Step 4.7, the line of the admin list that shows your pizza:
- Step 4.8, run 1, result, duration and pizza name:
- Step 4.8, run 2, result, duration and pizza name:
- Step 4.9 (optional), browser and result:

## Part B
1. 
2. 
3. 
4. 
5. 
6. 
7. 
