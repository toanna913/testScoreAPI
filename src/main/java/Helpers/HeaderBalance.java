package Helpers;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

public class HeaderBalance {
    public static Headers HeaderBalanceHelper(){
     //   String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoiMDk3NTMyOTkwNSIsInBhc3MiOiIwMDAwMDAiLCJrZXkiOiJtb21vIiwic2Vzc2lvbktleSI6InRJaTlNWjdXQXEvbHpVaS85OGRGUVN0SkphU0s0Mlo3VGY0VVhobUdqQ1hPZm1nZkhybnlCZz09IiwiaW1laSI6ImU5YWMyOWMxMTUwNDM2ZWNmOGFmYzFiYTUxZjRkNzIwOTk1MTUzZjE5YzgwYjg1MzQ2NjdkNTVkNGQwODg5ZGMiLCJCQU5LX0NPREUiOiIxMjM0NSIsIkJBTktfTkFNRSI6IlZpZXRjb21iYW5rIiwiTUFQX1NBQ09NX0NBUkQiOjAsIk5BTUUiOiJOZ3V5ZW4gVmFuIEEiLCJJREVOVElGWSI6IkNPTkZJUk0iLCJERVZJQ0VfT1MiOiJhbmRyb2lkIiwiQVBQX1ZFUiI6NDAxNjAsImFnZW50X2lkIjo0MjgwMzk0NywiTkVXX0xPR0lOIjp0cnVlLCJwaW4iOiIvcDVUd2txZ2pRWT0iLCJpc1Nob3AiOmZhbHNlLCJpYXQiOjE2NzgxNzc3NTF9.BHKz64_DVxuYd3v25kyJLSJ81MhZPaunwFycGBYAsvZjjPYd9aY6licJ6KoXQrEArEsTu207XM9R4XzDcxDjIIHGcTrtqqlHNRiEhz4OJ44OHGeq4IMJjJzYbOcE1SPivCeOc6hSDEZIuyRp2qX0TmsIMbyex40KoqNMkjn67CpqfBuVGBA5W7_bvcObXvcb0L57ZsPpqM8tpBSD5R1A0-pBSZKplu5lGWvgsGQYLpsibkgb3QFf_r-OMYZEJ87d3HfvwrxAuj_y6JXNN3wrUxCOwBLffKFPiNWjB_6_qRX5i1lWa4mRLHeahJQwqetvb_znu0aXhr0hx3uHFoWmgA";
       Header contentType = new Header("Content-Type","application/json");
      //  Header authorization = new Header("Authorization", "Bearer "+token);
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(contentType);
      //  headerList.add(authorization);
        Headers header = new Headers(headerList);
        return header;
    }
}
