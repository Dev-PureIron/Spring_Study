package com.example.expert.repository.pay;

import com.example.expert.entity.product.Product;
import com.example.expert.entity.product.ProductDTO;
import com.example.expert.entity.product.QProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.expert.entity.member.QMember.member;
import static com.example.expert.entity.order.QOrder.order;
import static com.example.expert.entity.pay.QPay.pay;
import static com.example.expert.entity.product.QProduct.product;

import java.util.List;
import java.util.Optional;

public class PayQueryDslImpl implements PayQueryDsl {
    @Autowired
    private JPAQueryFactory query;

    @Override
    public List<ProductDTO> findCountOfOrder() {
        return query.select(
                new QProductDTO(
                        pay.product.id,
                        pay.product.productName,
                        pay.product.productStock,
                        pay.product.productPrice,
                        pay.order.count().intValue()))
                .from(pay)
                .groupBy(pay.product.id,
                        pay.product.productName,
                        pay.product.productStock,
                        pay.product.productPrice).fetch();
    }

    @Override
    public Optional<ProductDTO> findTop1ProductByOrder() {
        return Optional.ofNullable(query.select(new QProductDTO(
                pay.product.id,
                pay.product.productName,
                pay.product.productStock,
                pay.product.productPrice,
                pay.order.count().intValue()))
                .from(pay)
                .groupBy(pay.product.id,
                        pay.product.productName,
                        pay.product.productStock,
                        pay.product.productPrice)
                .orderBy(pay.order.count().desc())
                .offset(0)
                .limit(1)
                .fetchOne());
    }
}











