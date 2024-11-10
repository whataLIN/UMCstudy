package umc.spring.repository.TermRepository;

import umc.spring.domain.Terms;

import java.util.List;

public interface TermRepositoryCustom {
    List<Terms> findAllTermsforMember(Long memberId);
}
