drop table if exists product;

create table if not exists product(
productId varchar(10) not null,	
pname varchar(20) ,			
unitPrice integer, 		
descriptions text, 	
manufacturer  varchar(20) ,	
category  varchar(20) , 		
unitsInStock long, 	
conditions varchar(20) , 		
filename  varchar(20) ,    	
primary key (productId)		
);

# insert 추가
insert into product values(
'P1234',  
'iPhone 6s',
 800000, 
 '4.7-inch, 1334X750 Renina HD display, 8-megapixel iSight Camera', 
 'Apple', 
 'Smart Phone', 
 1000, 
 'New', 
 'P1234.png' );

insert into product values(
'P1235',  
'LG PC 그램', 
1500000, '13.3-inch, IPS LED display, 5rd Generation Intel Core processors',
 'LG',
 'Notebook',
 1000,
 'Refurbished', 
'P1235.png'  );

insert into product values(
'P1236',  
'Galaxy Tab S',
 900000, 
'212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor', 
'Samsung', 
'Tablet', 
1000, 
'Old', 
'P1236.png'  );

# Read 조회
use webmarketdb ; 
select * from product ; 

-- # update 수정
-- update product set  pname = 'Galaxy T S' where productId = 'P1236';

-- # delete 삭제
-- delete from product where productId =  'P1236';