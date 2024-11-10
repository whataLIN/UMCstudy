package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MemberRepository.MemberRepositoryImpl;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberRepositoryImpl memberRepositoryImpl;

    @Override
    public void changeMemberName(Long memberId, String newName) {
        memberRepositoryImpl.updateMemberName(memberId, newName);
    }

}
