package com.plateer.study.day7;

// 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class SolutionTwo {
    public static void main(String[] args) {
        int n = 5000;
        solution(n);
    }
    public static int solution(int n) {
        SuperMan superMan = new SuperMan(0, 0, 0);


        return superMan.getEnergy();
    }

    public static class SuperMan {
        private int location;
        private int teleportLocation;
        private int energy;

        public SuperMan(int location, int teleportLocation, int energy) {
            this.location = location;
            this.teleportLocation = teleportLocation;
            this.energy = energy;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public int getTeleportLocation() {
            return teleportLocation;
        }

        public void setTeleportLocation(int teleportLocation) {
            this.teleportLocation = teleportLocation;
        }

        public int getEnergy() {
            return energy;
        }

        public void setEnergy(int energy) {
            this.energy = energy;
        }
    }
}
