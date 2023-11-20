package telran.multithreading.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public record Monitor(Lock lockRead, Lock lockWrite, AtomicInteger locksCounter) {

}
