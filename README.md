# Automated UI Testing (ITDS362) - ui-lab

คลังเก็บงานการทดสอบ UI อัตโนมัติ (Automated UI Testing) สำหรับวิชา **ITDS362 Software Quality Assurance and Testing** โดยพัฒนาชุดทดสอบบนเว็บฟอร์มทดสอบของ Selenium และระบบ QuickPizza (https://quickpizza.grafana.com)

เครื่องมือที่เลือกใช้ทำในแล็บนี้มี 2 ส่วน:
- **Part 2**: Selenium WebDriver with Java and JUnit 5
- **Part 4**: Cypress (JavaScript / Node.js)

สำหรับรายละเอียดผลการทดสอบ ตัวระบุตำแหน่ง (Locators) สรุปเวลาการรัน และคำตอบสะท้อนความคิดเห็น (Reflection Part B) สามารถดูได้ที่ [RESULTS.md](RESULTS.md)

---

## รายละเอียดโฟลเดอร์และคำสั่งรันชุดทดสอบ

### 1. `selenium-java/` (Part 2)
โฟลเดอร์นี้บรรจุโปรเจกต์ Maven สำหรับทดสอบเว็บฟอร์มและกระบวนการสั่งพิซซ่า QuickPizza (QP-01) ด้วยภาษา Java, Selenium WebDriver 4.52.0 และ JUnit 6.1.3 โดยนำสถาปัตยกรรม Page Object Model (`HomePage` และ `AdminPage`) มาใช้เพื่อแยกโค้ดระบุตำแหน่งออกจากเทสเคส พร้อมทั้งมีระบบจับภาพหน้าจอ (Screenshots) เป็นหลักฐานการทดสอบอัตโนมัติ

**คำสั่งสำหรับรันการทดสอบทั้งหมด:**
```bash
mvn test -Dheadless=true
```
*(รันคำสั่งจากภายในโฟลเดอร์ `selenium-java/` โดยต้องตั้งค่าตัวแปรสภาพแวดล้อม `CHROMEDRIVER` ชี้ไปยังตำแหน่งไฟล์ ChromeDriver)*

---

### 2. `cypress/` (Part 4)
โฟลเดอร์นี้บรรจุโปรเจกต์ Node.js สำหรับทำ End-to-End Testing ด้วย Cypress 16.2.1 ครอบคลุมการทดสอบเว็บฟอร์ม (`web-form.cy.js`) และการทดสอบ QuickPizza (`pizza-scenario.cy.js`) ซึ่งมีการใช้ Custom Command สำหรับการเข้าสู่ระบบของผู้ดูแลระบบ การใช้ `cy.intercept` ตรวจสอบ Network API และการบันทึกหลักฐานผลการทดสอบเป็นไฟล์วิดีโอ `.mp4` และภาพหน้าจอโดยอัตโนมัติ

**คำสั่งสำหรับรันการทดสอบทั้งหมด:**
```bash
npx cypress run --browser chrome
```
*(รันคำสั่งจากภายในโฟลเดอร์ `cypress/`)*
