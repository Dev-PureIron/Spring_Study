package com.example.expert.repository.member;

import com.example.expert.entity.member.Member;
import com.example.expert.entity.member.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.expert.entity.member.QMember.member;

@RequiredArgsConstructor
public class MemberQueryDslImpl implements MemberQueryDsl {
    private final JPAQueryFactory query;

    @Override
    public Optional<Member> findPaysById_QueryDSL(Long id) {
        return Optional.ofNullable(
                query.select(member)
                        .from(member)
                        .join(member.pays)
                        .fetchJoin()
                        .where(member.id.eq(id))
                        .fetchOne());
    }

    @Override
    public Optional<Member> findOrdersById_QueryDSL(Long id) {
        return Optional.ofNullable(
                query.select(member)
                        .from(member)
                        .join(member.orders)
                        .fetchJoin()
                        .where(member.id.eq(id))
                        .fetchOne());
    }
}














