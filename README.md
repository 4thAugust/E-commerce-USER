# E-commerce-Module USER (by August Team)

## :computer: User Interface Design
https://4thaugust.github.io/E-commerce-USER/

## :computer: Service Diagram Design
![service diagram-UserService](https://user-images.githubusercontent.com/41178248/101269903-27fe2d00-37a6-11eb-83dd-11131663d760.png)

## :wrench: API
- /createUser/ สร้างข้อมูลผู้ใช้
- /getUser/<:userName> ดึงข้อมูลผู้ใช้ผ่าน username
- /getUser/<:id> ดึงข้อมูลผู้ใช้ผ่าน id
- /getAllUser ดึงข้อมูลผู้ใช้งานในระบบทุกคน
- /createAddress/ สร้างที่อยู่ของผู้ใช้
- /getAddress/<:userName> ดึงข้อมูลที่อยู่อยู่ของผู้ใช้
- /updateAddress/<:my_address_id> แก้ไขข้อมูลที่อยู่ที่ id นั้น
- /deleteAddress/<:my_address_id> ลบไขข้อมูลที่อยู่ที่ id นั้น




## :page_with_curl: Database Update 23/11/20

![USER 9_11 (3)](https://user-images.githubusercontent.com/41178248/99928045-123a4200-2d7a-11eb-891c-0c5a7424efa3.png)





1. ผู้ใช้ (USER)
   * ไอดี (id)
   * ชื่อบัญชีผู้ใช้ (userName)
   * ชื่อ (firstName)
   * นามสกุล (lastName)
   * อีเมล (email)
   * เพศ (gender)
   * เบอร์โทร (phone)
   * วันเกิด (dateOfBirth)

   
2. ที่อยู่ของผู้ใช้งาน (MY_ADDRESS)
   * ไอดี (my_address_id)
   * ไอดีผู้ใช้ (USER_id)
   * ชื่อผู้รับ (name)
   * เบอร์โทรศัพท์ผู้รับ (phone)
   * จังหวัด (province)
   * อำเภอ (district)
   * รายละเอียดที่อยู่ เช่น บ้านเลขที่ ชื่อถนน ซอย ตึก (address)
   * รหัสไปรษณีย์ (postal_code)
   

   
# หมายเหตุ 
- ผู้ใช้งาน (USER) จะมี Password เก็บอยู่ใน DB จากอีกตาราง ในส่วนนี้รอจาก module authen
- ผู้ใช้งาน (USER) สามารถดูประวัติการสั่งซื้อได้ ซึ่งจะมี FK ที่ต้องเชื่อมมาว่า Order นั้นเป็นคน User นั้น โดยข้อมูลในส่วนนี้รอจาก Module Order         
- ผู้ใช้งาน (USER) สามารถมีที่อยู่ (address) ได้หลายข้อมูลจึงทำให้เกิดการแยกตารางเก็บออกมาเป็นตารางใหม่ชื่อ MY_ADDRESS ที่มี FK คือ USER_id


# Run
- Run UserApplication.java
- Run Web UI 
