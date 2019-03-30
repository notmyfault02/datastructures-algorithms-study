package cc.yaboong.ds.builtin;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Created by yaboong on 2018. 1. 22..
 */
public class BuiltinPriorityQueueExample {
    public static void main(String[] args){
        class Member implements Comparable<Member> {
            private String name;
            private int angerGage;

            public Member(String name, int angerGage){
                this.name = name;
                this.angerGage = angerGage;
            }

            @Override
            public int compareTo(Member m) {
                if      (this.angerGage < m.angerGage)  return -1;
                else if (this.angerGage > m.angerGage)  return  1;
                else                                    return  0;
            }
        }

        Queue<Member> pq = new PriorityQueue<>();

        Member yaboong = new Member("yaboong", 90);
        Member sol = new Member("sol", 70);
        Member pg = new Member("pg", 80);
        Member ho = new Member("ho", 30);

        pq.offer(yaboong);
        pq.offer(sol);
        pq.offer(pg);
        pq.offer(ho);

        while(!pq.isEmpty()){
            Member m = pq.poll();
            System.out.println(m.name + " " + m.angerGage);
        }
    }
}

