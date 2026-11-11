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
- Step 2.15, QP01Test run 1, result and time: Pass, 9.844 s (Tests run: 1, Failures: 0)
- Step 2.15, QP01Test run 2, result and time: Pass, 12.35 s (Tests run: 1, Failures: 0)
- Step 2.20, full run 1, time and number of tests: 51.019 s, 5 tests, 0 failures
- Step 2.20, full run 2, time and number of tests: 28.829 s, 5 tests, 0 failures

## Part 4: Cypress
- node --version, npm --version and npx cypress version: v24.19.0, 11.17.0, Cypress package version: 16.2.1
- Step 4.3, failure message for the wrong title: `Timed out retrying after 10000ms` / `+ expected - actual` / `-'Web form'` / `+'Web Form'`
- Step 4.6, tool and calories in the answer of POST /api/pizza: Scissors, 450 calories per slice (run 2; status 200, request maxCaloriesPerSlice = 600, the page showed the same tool and calories)
- Step 4.7, the line of the admin list that shows your pizza: `Lab Pizza 20261111-084934 (tool=Scissors, ingredients_number=7)` (run 2)
- Step 4.8, run 1, result, duration and pizza name: Pass, 2 of 2 tests, 00:17 (pizza-scenario 00:12, web-form 00:05), Lab Pizza 20261111-084859
- Step 4.8, run 2, result, duration and pizza name: Pass, 2 of 2 tests, 00:14 (pizza-scenario 00:11, web-form 00:02), Lab Pizza 20261111-084934
- Step 4.9 (optional), browser and result: not done

## Part B
1. 
2. 
3. 
4. 
5. 
6. 
7. 
