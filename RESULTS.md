# ผลลัพธ์การทดลอง UI Lab (UI lab results)

เครื่องมือที่เลือกทำ (Tool parts that I chose): Part 2 (Selenium WebDriver in Java) และ Part 4 (Cypress)

---

## Part 0: การเตรียมความพร้อมเบื้องต้น (Part 0)
- Step 0.1, Chrome version (เวอร์ชัน Chrome): Google Chrome 157.0.8103.51 (arm64)
- Step 0.3, ChromeDriver version (เวอร์ชัน ChromeDriver): ChromeDriver 157.0.8103.51
- Step 0.4, locator of Pizza, Please! (ตัวระบุตำแหน่งของปุ่ม Pizza, Please!): `button[name="pizza-please"]` (พบ 1 element พอดี)
- Step 0.4, locator of Excluded tools (ตัวระบุตำแหน่งรายการ Excluded tools): `select[multiple]` (พบ 1 element พอดี)
- Step 0.4, locator of Must be vegetarian (ตัวระบุตำแหน่งกล่องติ๊ก Must be vegetarian): `#default-checkbox` (พบ 1 element พอดี)
- Step 0.4, locator of Custom Pizza Name (ตัวระบุตำแหน่งช่อง Custom Pizza Name): `input#pizza-name` (พบ 1 element พอดี; หากใช้ `#pizza-name` ตัวเดียวจะเจอ 2 elements หลังการ์ดคำแนะนำแสดง)
- Step 0.5, pizza name, tool and calories of the run by hand (ชื่อพิซซ่า เครื่องมือ และแคลอรีจากการรันด้วยมือ): Lab Pizza 20261111-082800, Pizza cutter, 400 calories per slice

| ขั้นตอน (Step) | ผลลัพธ์จริงที่พบ (Actual result) | ผลการทดสอบ (Pass or fail) |
|---|---|---|
| 1 | ข้อความหัวข้อแสดง "Looking to break out of your pizza routine?" ชัดเจนบนหน้าแรก | ผ่าน (Pass) |
| 2 | เมื่อเปิดสวิตช์ Advanced พบฟิลด์ Max Calories per Slice (ค่าเริ่มต้น 1000), Excluded tools (Knife, Pizza cutter, Scissors), Must be vegetarian และ Custom Pizza Name ปรากฏขึ้นมาครบถ้วน | ผ่าน (Pass) |
| 3 | ปรับค่าเป็น 600 แคลอรี, เลือกตัด Knife ออก, ติ๊กเลือก vegetarian และกรอกชื่อพิซซ่า Lab Pizza 20261111-082800 ได้ถูกต้องครบทุกช่อง | ผ่าน (Pass) |
| 4 | การ์ดคำแนะนำแสดง Name: Lab Pizza 20261111-082800, Tool: Pizza cutter (ไม่ใช่ Knife) และ Calories per slice: 400 (ไม่เกิน 600) | ผ่าน (Pass) |
| 5 | เมื่อคลิกปุ่ม Love it! โดยยังไม่ได้เข้าสู่ระบบ หน้าเว็บแสดงข้อความแจ้งเตือน "Please log in first." | ผ่าน (Pass) |
| 6 | ช่องกรอกในหน้า /admin มีคำว่า admin เติมไว้อยู่แล้วทั้งสองช่อง และเมื่อคลิก Sign in หน้าเว็บเปลี่ยนไปแสดงหัวข้อ "Latest pizza recommendations" | ผ่าน (Pass) |
| 7 | ในรายการแนะนำของแอดมิน ปรากฏแถวข้อมูล: Lab Pizza 20261111-082800 (tool=Pizza cutter, ingredients_number=7) ซึ่งใช้เครื่องมือตรงกับขั้นตอนที่ 4 | ผ่าน (Pass) |

---

## Part 2: Selenium WebDriver in Java
- Step 2.4, the failure line for the wrong title (บรรทัดข้อผิดพลาดกรณีตั้งไตเติลผิด): `[ERROR]   FirstTest.webFormOpens:20 expected: <Web Form> but was: <Web form>`
- Step 2.15, QP01Test run 1, result and time (ผลการรัน QP01Test รอบที่ 1 และเวลา): ผ่าน (Pass), 9.844 วินาที (Tests run: 1, Failures: 0)
- Step 2.15, QP01Test run 2, result and time (ผลการรัน QP01Test รอบที่ 2 และเวลา): ผ่าน (Pass), 12.35 วินาที (Tests run: 1, Failures: 0)
- Step 2.20, full run 1, time and number of tests (ผลการรันเต็มรอบที่ 1 เวลา และจำนวนเทส): ผ่านทั้งหมด 5 เทส ไม่มีข้อผิดพลาด (5 tests, 0 failures), เวลา 51.019 วินาที
- Step 2.20, full run 2, time and number of tests (ผลการรันเต็มรอบที่ 2 เวลา และจำนวนเทส): ผ่านทั้งหมด 5 เทส ไม่มีข้อผิดพลาด (5 tests, 0 failures), เวลา 28.829 วินาที

---

## Part 4: Cypress
- node --version, npm --version and npx cypress version (เวอร์ชัน Node, npm และ Cypress): v24.19.0, 11.17.0, Cypress package version: 16.2.1
- Step 4.3, failure message for the wrong title (ข้อความแจ้งเตือนกรณีตั้งไตเติลผิด): `Timed out retrying after 10000ms` / `+ expected - actual` / `-'Web form'` / `+'Web Form'`
- Step 4.6, tool and calories in the answer of POST /api/pizza (เครื่องมือและแคลอรีในการตอบกลับของ POST /api/pizza): Scissors, 450 calories per slice (ผลลัพธ์จากการรันรอบที่ 2: สถานะ HTTP 200, ข้อมูลใน request body ส่ง maxCaloriesPerSlice = 600 และข้อมูลบนหน้าเว็บแสดงผลตรงกับ payload ที่ได้รับจากเซิร์ฟเวอร์)
- Step 4.7, the line of the admin list that shows your pizza (บรรทัดข้อมูลในรายการแอดมินที่แสดงพิซซ่า): `Lab Pizza 20261111-084934 (tool=Scissors, ingredients_number=7)` (จากการรันรอบที่ 2)
- Step 4.8, run 1, result, duration and pizza name (ผลการรันเต็มรอบที่ 1 ระยะเวลา และชื่อพิซซ่า): ผ่าน (Pass), 2 จาก 2 เทส, เวลา 00:17 วินาที (pizza-scenario 00:12, web-form 00:05), ชื่อพิซซ่า Lab Pizza 20261111-084859
- Step 4.8, run 2, result, duration and pizza name (ผลการรันเต็มรอบที่ 2 ระยะเวลา และชื่อพิซซ่า): ผ่าน (Pass), 2 จาก 2 เทส, เวลา 00:14 วินาที (pizza-scenario 00:11, web-form 00:02), ชื่อพิซซ่า Lab Pizza 20261111-084934
- Step 4.9 (optional), browser and result (การรันบนเบราว์เซอร์ตัวที่สอง): ไม่ได้ทำ (not done)

---

## Part B: คำตอบสะท้อนความคิดเห็น (Reflection)

### 1. เหตุผลที่ค้นหาช่อง Max Calories per Slice ผ่านข้อความของ label แทนการใช้ id และแนวทางปรับปรุงหน้าเว็บ:
ชุดทดสอบต้องค้นหาช่อง 'Max Calories per Slice' ผ่านข้อความของ label แทนการใช้ id เนื่องจากจากการตรวจสอบด้วยคำสั่ง `$$("#floating_filled").length` ใน Console พบว่าช่องกรอกตัวเลขทั้ง 3 ช่องบนหน้าเว็บใช้ค่า `id="floating_filled"` ซ้ำกันทั้งหมด ทำให้การระบุด้วย id มีความคลุมเครือและไม่ถูกต้องตามมาตรฐาน HTML เพื่อแก้ไขปัญหานี้ นักพัฒนาเว็บควรเปลี่ยนให้แต่ละช่องมี id ที่เฉพาะเจาะจงและสื่อความหมาย เช่น `id="max-calories-per-slice"` พร้อมทั้งผูก attribute `for` ของ label ให้ตรงกัน การปรับปรุงนี้จะช่วยให้ผู้ทดสอบสามารถเขียน locator ได้สั้นและเสถียร (`#max-calories-per-slice`) โดยไม่พังเมื่อโครงสร้าง DOM หรือข้อความบน label มีการปรับเปลี่ยนหรือแปลเป็นภาษาอื่น

### 2. ชนิดของ Test Oracle ในขั้นตอนที่ 7 และข้อบกพร่องที่สามารถตรวจจับได้:
การเปรียบเทียบเครื่องมือ (tool) ในหน้ารายการของ admin กับเครื่องมือที่แสดงในหน้าคำแนะนำของลูกค้าในขั้นตอนที่ 7 จัดเป็น **Consistency Oracle (การตรวจสอบความสอดคล้องของสถานะระบบ)** ซึ่งแทนที่จะเทียบกับค่าคงที่ตายตัว ระบบจะตรวจสอบว่าข้อมูลในมุมมองที่ต่างกันสะท้อนสถานะที่แท้จริงเดียวกัน การตรวจสอบนี้ช่วยดักจับข้อผิดพลาดด้านการบันทึกข้อมูล (Persistence fault) เช่น กรณีที่ฝั่งเซิร์ฟเวอร์สุ่มสร้างพิซซ่าด้วยเครื่องมือหนึ่ง (เช่น Scissors ในการรัน Cypress รอบที่ 2) แต่กลับบันทึกลงฐานข้อมูลเป็นเครื่องมืออื่นหรือเป็นค่า default นอกจากนี้ยังช่วยตรวจจับปัญหา Race Condition หรือข้อผิดพลาดของการเชื่อมโยง Session ระหว่างผู้ใช้งานหลายคนที่เข้าใช้งานพร้อมกันได้อีกด้วย

### 3. แนวทางการตรวจสอบว่าพิซซ่าที่ได้เป็นมังสวิรัติ (Vegetarian) จริง:
เพื่อตรวจสอบว่าพิซซ่าที่ได้เป็นมังสวิรัติ (Vegetarian) จริง การทดสอบสามารถตรวจสอบค่า `response.body.vegetarian === true` จาก Network payload ผ่าน `cy.intercept` หรือตรวจสอบจากข้อความรายชื่อวัตถุดิบ (Ingredients) บนหน้าเว็บ หากต้องการตรวจสอบจากหน้า UI โดยตรงโดยไม่พึ่งพา flag ของเซิร์ฟเวอร์ ชุดทดสอบจำเป็นต้องมีพจนานุกรมหรือรายการอ้างอิง (Blacklist) ของวัตถุดิบที่ไม่ใช่มังสวิรัติจากภายนอก เช่น Pepperoni, Ham, Bacon, Chicken หรือ Beef จากนั้นชุดทดสอบจะดึงข้อความส่วน Ingredients ใต้ `#recommendations` (เช่น ในรอบรันมือที่ได้ Mozzarella, Onions, Eggplant, Jalapenos, Kalamata olives, Extra virgin olive oil, Bianco di Nizza tomatoes) มาตัดแบ่งเป็นรายชื่อวัตถุดิบ แล้วทำ assertion ยืนยันว่าไม่มีวัตถุดิบใดตรงกับรายการเนื้อสัตว์ หรือตรวจสอบว่ามีการ์ดระบุเครื่องหมาย Vegetarian ชัดเจนตามที่หน้าเว็บกำหนด

### 4. เปรียบเทียบเครื่องมือทั้งสอง (Selenium WebDriver with Java vs Cypress):
เครื่องมือทั้งสองมีกลไกการรอ (Wait) ที่แตกต่างกันอย่างชัดเจน โดย Selenium WebDriver ใน Java จำเป็นต้องเขียนคำสั่งรอแบบ Explicit Wait ผ่าน `WebDriverWait` และ `ExpectedConditions` (เช่น `visibilityOfElementLocated` หรือ `elementToBeClickable`) ด้วยตนเองในทุกจุดที่มีการโหลดแบบไดนามิก มิฉะนั้นจะเกิดข้อผิดพลาด `NoSuchElementException` ในขณะที่ Cypress มีกลไกการรอและลองใหม่ (Automatic Retry) ในตัวสำหรับทุกคำสั่ง `cy.get()` และ assertion สูงสุด 10 วินาที ทำให้การเขียนโค้ด QP-01 ด้วย Cypress ทำได้รวดเร็วกว่ามาก เพราะมี syntax แบบ chaining ที่กระชับและมี `cy.intercept` ช่วยดักตรวจ Network request ได้ในตัวโดยไม่ต้องตั้งค่า driver ให้ยุ่งยาก ด้านการอ่านผลลัพธ์ Cypress มีความชัดเจนและตรวจสอบง่ายกว่าอย่างเห็นได้ชัดด้วยไฟล์วิดีโอ `.mp4` ที่บันทึกการทำงานทั้งหมด (ใช้เวลารันเพียง 14 วินาทีในรอบที่ 2) ร่วมกับ Command Log แบบ time-travel บนหน้าเว็บ ในขณะที่ Selenium ให้ผลลัพธ์เป็นไฟล์ข้อความสรุปจาก Maven Surefire (ใช้เวลารัน 28.8 วินาที) ควบคู่กับไฟล์ภาพหน้าจอแบบ static เท่านั้น

### 5. การเลือกเครื่องมือสำหรับการทดสอบ UI อัตโนมัติใน Project 2:
สำหรับการทดสอบ Automated UI ใน Project 2 ผมเลือกใช้ **Cypress** เป็นเครื่องมือหลัก เหตุผลแรกคือ Cypress มีระบบ Automatic Waiting and Retry ในตัวที่ช่วยลดปัญหาการทดสอบไม่เสถียร (Flaky tests) และช่วยลดภาระในการเขียนและบำรุงรักษาโค้ดรอองค์ประกอบต่างๆ ของหน้าเว็บที่โหลดแบบไดนามิก เหตุผลที่สองคือ Cypress มีฟีเจอร์ด้าน Observability และ Debugging ที่ยอดเยี่ยม โดยสามารถบันทึกวิดีโอการรันเทสได้ทันที และมีคำสั่ง `cy.intercept` ที่ช่วยให้เราตรวจสอบการทำงานของ UI ควบคู่ไปกับความถูกต้องของ REST API และ Network payload ได้อย่างสมบูรณ์แบบโดยไม่ต้องติดตั้งไลบรารีเสริมเพิ่มเติม

### 6. (คำถามสำหรับ Part 2) การเปลี่ยนแปลงเมื่อ locator ของช่อง calories เปลี่ยน และประโยชน์ของ Page Object Model:
หาก QuickPizza มีการเปลี่ยน locator ของช่อง calories ในไฟล์ `QP01Test.java` เราจะต้องเข้าไปตามแก้ค่า XPath ดิบ `//label[normalize-space()='Max Calories per Slice']/preceding-sibling::input` ภายในเมธอดทดสอบโดยตรง และหากมีเทสเคสอื่นที่เรียกใช้ช่องนี้ก็จะต้องตามไปแก้ในทุกๆ ไฟล์ด้วย แต่ในกรณีของ `QP01PageObjectTest.java` ตัวเทสเคสจะเรียกใช้งานผ่านเมธอดระดับสูงอย่าง `home.setMaxCalories(600)` และ `home.maxCalories()` เท่านั้น โดยไม่มี locator ปรากฏอยู่ในตัวเทสเคสเลย ดังนั้นเมื่อใช้ Page Object Model การแก้ไขจึงเกิดขึ้นเพียงจุดเดียวคือการอัปเดตค่าคงที่ `MAX_CALORIES` ในไฟล์ `HomePage.java` ซึ่งช่วยให้การซ่อมแซมโค้ดมีขนาดเล็กมาก และแยกการเปลี่ยนแปลงของโครงสร้างหน้าเว็บออกจาก logic การทดสอบได้อย่างชัดเจน

### 7. (คำถามสำหรับ Part 4) เหตุผลที่ QP-01 ใน Cypress ต้องเป็นเทสเคสเดียว และผลกระทบหากแยกขั้นตอนที่ 6 และ 7:
ใน Cypress การทำงานของแต่ละบล็อก `it(...)` จะถูกแยกขาดจากกัน (Test Isolation) โดย Cypress จะล้างค่าสถานะของเบราว์เซอร์ทั้งหมด ไม่ว่าจะเป็น cookies, localStorage และ sessionStorage โดยอัตโนมัติก่อนเริ่มเทสเคสถัดไปเสมอ สำหรับ QuickPizza ตัวระบบทำงานอยู่บนเซิร์ฟเวอร์หลายเครื่องและอาศัย Session Cookie ในการทำ Server Affinity เพื่อให้เบราว์เซอร์เชื่อมต่อไปยังเซิร์ฟเวอร์เครื่องเดิมที่เก็บข้อมูลพิซซ่าที่เพิ่งสร้างไว้ในหน่วยความจำ หากเราแยกขั้นตอนที่ 6 และ 7 ออกไปเป็นเทสตัวที่สอง Cypress จะล้างคุกกี้ดังกล่าวทิ้งก่อนเข้าสู่หน้า admin ทำให้คำขอล็อกอินอาจถูกส่งไปยังเซิร์ฟเวอร์คนละเครื่อง ส่งผลให้การค้นหาชื่อพิซซ่า (เช่น `Lab Pizza 20261111-084934`) ในรายการของ admin ล้มเหลวเนื่องจากหาข้อมูลไม่พบและหมดเวลา (Timeout)
