package Spring.soospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.sound.midi.SysexMessage;

//Aop선언
@Aspect
@Component //컴포넌트에 등록
public class TimeTraceAop {

    @Around("execution(* Spring.soospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
       long start = System.currentTimeMillis();
       System.out.println("처음 메소드 진행 시간 :" + joinPoint.toString());
       try {
           //다음 메소드로 진행
           return joinPoint.proceed();
       } finally {
           long finish = System.currentTimeMillis();
           long timeMs = finish - start;
           System.out.println("끝나는 시간 :" + joinPoint.toString() + "" + timeMs + "ms");
       }
    }

}
