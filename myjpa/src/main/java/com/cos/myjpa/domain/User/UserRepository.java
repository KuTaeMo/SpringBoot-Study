package com.cos.myjpa.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{

	// 없는 함수 만들기
	// 1. naming query - findBy까지는 있는 함수이고 그 다음 꺽이는 문자부터 찾아줌 (간단한거 만들 때 좋음)
	// select * from user where username=?1
	//User findByUsername(String username);
	
	// select * from user where username=?1 and password?2
	User findByUsernameAndPassword(String username, String password);
	
	// 2. native query (복잡한거 만들기 좋음)
	//@Query(value="SELECT * FROM user WHERE username=:username AND password=:password",nativeQuery = true)
	@Query(value="SELECT * FROM user WHERE username=?1 AND password=?2",nativeQuery = true)
	User mLogin(String username,String password);
	
	// 3. 동적 query 라이브러리 - QueryDSL
}
