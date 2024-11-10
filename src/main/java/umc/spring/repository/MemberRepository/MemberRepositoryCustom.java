package umc.spring.repository.MemberRepository;

import umc.spring.domain.Member;

public interface MemberRepositoryCustom {

    Member findMemberById(Long id);
    void updateMemberName(Long id, String newName);
}
