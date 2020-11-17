# E-commerce-Module USER (by August Team)

# Last Update 9/11/2020

## :computer: User Interface 
https://4thaugust.github.io/E-commerce-USER/
## :wrench: API
-  /createUser/
- /getUser/<userName>
- /getAllUser
- /groupByGender/<gender>
- /groupByAge/<age_range>
- /createAddress/
- /getAddress/
- /updateAddress/<my_address_id>
- /deleteAddress/<my_address_id>

## :page_with_curl: Database 
![USER 9_11 (2)](https://user-images.githubusercontent.com/41178248/98644364-f048c480-2362-11eb-91b6-bd0953792534.png)


1. ผู้ใช้ (USER)
   * ไอดี (id)
   * ชื่อบัญชีผู้ใช้ (userName)
   * อีเมล (email)
   * ชื่อ (firstName)
   * นามสกุล (lastName)
   * เพศ (gender)
   * เบอร์โทร (phone)
   * วันเกิด (dateOfBirth)

   
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
