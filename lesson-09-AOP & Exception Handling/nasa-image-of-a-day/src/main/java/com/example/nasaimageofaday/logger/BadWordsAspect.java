package com.example.nasaimageofaday.logger;

import com.example.nasaimageofaday.model.Comment;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class BadWordsAspect {

    @AfterThrowing(pointcut = "execution(* com.example.nasaimageofaday.service.impl.CommentService.save(..))", throwing = "e")
    public void logBadWordException(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Comment comment = (Comment) joinPoint.getArgs()[0];
        String author = comment.getAuthorName();
        String commentText = comment.getCommentText();
        LocalDateTime timestamp = LocalDateTime.now();

        System.out.printf("[CMS] co loi xay ra: %s.%s%s: %s, Author: %s \n Comment: %s \n Timestamp: %s%n", className, method, args, e.getMessage(), author, commentText, timestamp);
    }

}
