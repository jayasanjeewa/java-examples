package com.example.queue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BlockingQueueUsingArrayTest {

    BlockingQueueUsingArray blockingQueueUsingArray = new BlockingQueueUsingArray(10);


    @Test
    public void shouldTakeFirstPut() throws Exception {
        blockingQueueUsingArray.put("Hello1");
        blockingQueueUsingArray.put("Hello2");

        assertThat(blockingQueueUsingArray.take(), is(equalTo("Hello1")) );
    }

    @Test
    public void get() throws Exception {
    }

}