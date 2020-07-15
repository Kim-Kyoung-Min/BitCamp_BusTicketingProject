package spms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 클래스 파일에 이 정보가 기록됨
// 실행시에도 유지됨.
// 즉, 실행시(런타임시)클래스에 기록된 annotation값을 참조할 수 있다.
// 이 클래스는  Component 에노테이션이 설정 되어 있구나!

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	//객체 이름을 저장할 용도
	String value() default "";
}
