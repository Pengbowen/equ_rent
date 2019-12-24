package com.bob.equrent.service;

import cn.hutool.core.util.StrUtil;
import com.bob.equrent.dao.UserDao;
import com.bob.equrent.entity.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public  Page<User> findUserPage(User user,int pageSize, int pageCount){
        List<Predicate> predicates = Lists.newArrayList();
        Specification<User> specification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            if (StrUtil.isNotEmpty(user.getName()))  predicates.add(criteriaBuilder.like(root.get("name"),"%"+user.getName()+"%"));
            if (StrUtil.isNotEmpty(user.getNikcname()))  predicates.add(criteriaBuilder.like(root.get("nickname"),"%"+user.getNikcname()+"%"));
            if (StrUtil.isNotEmpty(user.getMobile()))  predicates.add(criteriaBuilder.like(root.get("mobile"),"%"+user.getMobile()+"%"));
            if (StrUtil.isNotEmpty(user.getEmail()))  predicates.add(criteriaBuilder.like(root.get("email"),"%"+user.getEmail()+"%"));
            if (user.getId() != null)  predicates.add(criteriaBuilder.equal(root.get("id"),+user.getId()));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Pageable pageable = PageRequest.of(pageCount,pageSize);
        return this.userDao.findAll(specification,pageable);
    }
}
