create table s_post(
   id				varchar2(4000)	primary key,	
   board_id			number(9)		REFERENCES s_board(id),
   writer_id		varchar2(10)	REFERENCES s_party(user_id),
   title			varchar2(100),
   content			varchar2(4000),
 
);


select p.*
 from s_post p
 where board_id = 3
 	and(
 		title like '%테크%'
 		or
 		content like '%테크%'
 		)
 	order by id desc
 	offset 10 rows fetch first 10 rows only;
 	
 	
 	
 	 SELECT * FROM BLOG
  <where>
  
    <if test="state != null">
         state = #{state}
    </if>
    <if test="title != null">
        AND title like #{title}
    </if>
    <if test="author != null and author.name != null">
        AND author_name like #{author.name}
    </if>
  </where>
  
  
  Map<String, String> myMap = hashMap<>();
  myMap.put("T", "사랑");
  myMap.put("c", "행복");
  
  select *
    from s_post
   <trim prefix="where (" suffix=")" prefixOverrides="or">
   	<foreach collection="myMap" item="value" index="key">
   		<trim prefix="or">
   			<if test="key = 'C'.toString()">
   				content == #{value}
   			</if>
   			<if test="key = 'T'.toString()">
   				title == #{value}
   			</if>
   		</trim>
   	</foreach>
  </trim>
   