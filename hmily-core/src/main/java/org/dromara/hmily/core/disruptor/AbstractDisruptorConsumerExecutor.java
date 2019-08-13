/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.hmily.core.disruptor;

import java.util.HashSet;
import java.util.Set;

/**
 * DisruptorConsumerExecutor.
 * disruptor consumer executor.
 *
 * @param <T> the type parameter
 * @author chenbin sixh
 */
public abstract class AbstractDisruptorConsumerExecutor<T> {

    /**
     * 在用户需要订阅计算结果后记录订阅处理。
     */
    private Set<ExecutorSubscriber> subscribers = new HashSet<>();

    /**
     * 添加订阅者disruptor消费者执行者。
     *
     * @param subscriber subscriber；
     * @return the disruptor consumer executor
     */
    public AbstractDisruptorConsumerExecutor addSubscribers(final ExecutorSubscriber subscriber) {
        subscribers.add(subscriber);
        return this;
    }

    /**
     * 添加订阅者disruptor消费者执行者。
     *
     * @param subscribers the subscribers
     * @return the disruptor consumer executor
     */
    public AbstractDisruptorConsumerExecutor addSubscribers(final Set<ExecutorSubscriber> subscribers) {
        subscribers.forEach(this::addSubscribers);
        return this;
    }

    /**
     * 获得订阅者。
     *
     * @return the subscribers
     */
    public Set<ExecutorSubscriber> getSubscribers() {
        return subscribers;
    }

    /**
     * 执行当前事件的处理。
     *
     * @param data the data
     */
    public abstract void executor(T data);
}
