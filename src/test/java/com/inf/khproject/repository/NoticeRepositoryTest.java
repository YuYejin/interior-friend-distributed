package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void insertNotice() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().nickname("nicknamr"+ i).build();

            Notice notice = Notice.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer(member)
                    .build();

            noticeRepository.save(notice);

        });

    }

    @Test
    public void updateTest() {

        Optional<Notice> result = noticeRepository.findById(130L);

        if (result.isPresent()) {

            Notice notice = result.get();

            notice.changeTitle("Changed Title...");
            notice.changeContent("Changed Content...");

            noticeRepository.save(notice);

        }

    }

}