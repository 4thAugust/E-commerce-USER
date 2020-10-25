# E-commerce-Module USER (by August Team)

## :computer: User Interface 
https://4thaugust.github.io/E-commerce-USER/
## :wrench: Product Service 
-   สมัครสมาชิกลูกค้า (SignUp)
-   เข้าสู่ระบบ (Login)
-   ลบบัญชีผู้ใช้ (Delete)
-   แก้ไขข้อมูลบัญชี เช่น ชื่อ, ที่อยู่, รหัสผ่าน (Edit)
-   ดูประวัติรายการสั่งซื้อ (History)


## :page_with_curl: Database 

1. ผู้ใช้ (USER)
   * ไอดี (id)
   * ชื่อบัญชีผู้ใช้ (userName)
   * อีเมล (email)
   * ชื่อ (firstName)
   * นามสกุล (lastName)
   * เพศ (gender)
   * ที่อยู่ (address)

2. ที่อยู่ของผู้ใช้งาน (MY_ADDRESS)
  * ไอดี (my_address_id)
  * จังหวัด (province)
  * อำเภอ (district)
  * ตำบล (sub_district)
  * ถนน (road)
  * เลขที่ (number)
  * รหัสไปรษณีย์ (postal_code)

  
# หมายเหตุ 
- Password เก็บอยู่ใน DB module authen
- ประวัติการสั่งซื้อมี Key ที่ต้องเชื่อมไปหา Order จาก Module Order           
- ที่อยู่ (address) มีได้หลายข้อมูลทำให้เกิดการแยกตารางเก็บออกมาเป็นตารางใหม่ชื่อ MY_ADDRESS
