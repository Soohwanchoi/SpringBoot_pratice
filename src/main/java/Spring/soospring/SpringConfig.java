package Spring.soospring;

import Spring.soospring.Repository.JdbcMemberRepository;
import Spring.soospring.Repository.JdbcTemplateMemberRepository;
import Spring.soospring.Repository.MemberRepository;
import Spring.soospring.Repository.MemoryMemberRepository;
import Spring.soospring.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository((dataSource));
    }
}