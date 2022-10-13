package com.example.atddstudy.infra;

import com.example.atddstudy.domain.User;
import com.example.atddstudy.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryMemoryImpl implements UserRepository {

    private final AtomicLong atomicId = new AtomicLong(1);

    @Override
    public User save(User user) {
        user.assignId(nextId());
        return user;
    }

    private long nextId() {
        return atomicId.getAndIncrement();
    }
}
