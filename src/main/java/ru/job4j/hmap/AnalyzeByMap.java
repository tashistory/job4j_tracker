package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int k = 0;
        int sum = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                k++;
                sum += s.score();
            }
        }
        return (double) sum / k;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rslt = new ArrayList<>();
        for (Pupil p : pupils) {
            int sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            rslt.add(new Label(p.name(), sum / pupils.size()));
        }
        return rslt;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        int sum = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                temp.put(s.name(), temp.getOrDefault(s.name(), 0) + s.score());
            }
        }
        List<Label> rslt = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rslt.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return rslt;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rslt = new ArrayList<>();
        for (Pupil p : pupils) {
            int sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            rslt.add(new Label(p.name(), sum));
        }
        rslt.sort(Comparator.naturalOrder());
        return rslt.get(rslt.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        int sum = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                if (temp.get(s.name()) == null) {
                    sum = 0;
                } else {
                    sum = temp.get(s.name());
                }
                temp.put(s.name(), sum + s.score());
            }
        }
        List<Label> rslt = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rslt.add(new Label(entry.getKey(), entry.getValue()));
        }
        rslt.sort(Comparator.naturalOrder());
        return rslt.get(rslt.size() - 1);
    }
}