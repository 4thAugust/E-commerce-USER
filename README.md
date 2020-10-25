# E-commerce-Module USER (by August Team)

# Last Update 25/10/20

## :computer: User Interface 
https://4thaugust.github.io/E-commerce-USER/
## :wrench: Product Service 
-   สมัครสมาชิกลูกค้า (SignUp)
-   เข้าสู่ระบบ (Login)
-   ลบบัญชีผู้ใช้ (Delete)
-   แก้ไขข้อมูลบัญชี เช่น ชื่อ, ที่อยู่, รหัสผ่าน (Edit)
-   ดูประวัติรายการสั่งซื้อ (History)


## :page_with_curl: Database 

![Copy of USER (3)](https://user-images.githubusercontent.com/41178248/97113442-f0b74d80-171c-11eb-97f3-0aa7c91a6ac2.png)



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
- ผู้ใช้งาน (USER) จะมี Password เก็บอยู่ใน DB จากอีกตาราง ในส่วนนี้รอจาก module authen
- ผู้ใช้งาน (USER) สามารถดูประวัติการสั่งซื้อได้ ซึ่งจะมี FK ที่ต้องเชื่อมมาว่า Order นั้นเป็นคน User นั้น โดยข้อมูลในส่วนนี้รอจาก Module Order         
- ผู้ใช้งาน (USER) สามารถมีที่อยู่ (address) ได้หลายข้อมูลจึงทำให้เกิดการแยกตารางเก็บออกมาเป็นตารางใหม่ชื่อ MY_ADDRESS ที่มี FK คือ USER_id
