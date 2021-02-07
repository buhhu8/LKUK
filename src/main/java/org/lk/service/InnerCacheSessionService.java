package org.lk.service;

import org.lk.model.domain.AuthorizationSessionEntity;
import org.lk.model.dto.SessionDto;
import org.lk.repository.jpa.JpaSessionRepository;
import org.lk.service.converter.Converter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@Service//("cacheService")
public class InnerCacheSessionService extends SesionService{

    private BlockingQueue<Integer> queue;
    private ExecutorService cacheThreadPool;

    public InnerCacheSessionService(Converter<AuthorizationSessionEntity, SessionDto> converter, JpaSessionRepository jpaSessionRepository) {
        super(converter, jpaSessionRepository);
        this.queue = new LinkedBlockingDeque<>();
        this.cacheThreadPool = Executors.newFixedThreadPool(3);
    }

    @Override
    public void saveSessionId(Integer id) {
        System.out.println("Put session with user ID " + id + " to queue to save it later");
        queue.add(id);

//        new SaveSessionThread().start();
        cacheThreadPool.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {

            }

            Integer sessionId = queue.poll();
            if (sessionId != null) {
                System.out.println("Start to save session ID " + sessionId);
                super.saveSessionId(sessionId);
            }
        });
    }

    class SaveSessionThread extends Thread {

        @Override
        public void run() {
            Integer sessionId = queue.poll();
            if (sessionId != null) {
                System.out.println("Start to save session ID " + sessionId);
                InnerCacheSessionService.super.saveSessionId(sessionId);
            }
        }

    }


}
