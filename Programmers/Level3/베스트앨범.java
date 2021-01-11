import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<Integer, String> reverseGenreMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> playMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer play = plays[i];
            
            if (genreMap.get(genre) == null) {
                genreMap.put(genre, play);
            } else {
                Integer existPlay = genreMap.get(genre);
                genreMap.put(genre, existPlay + play);
            }
            
            if (playMap.get(genre) == null) {
                playMap.put(genre, new HashMap<Integer, Integer>());
                playMap.get(genre).put(i, play);
            } else {
                Map<Integer, Integer> playIndexMap = playMap.get(genre);
                playIndexMap.put(i, play);
            }
        }
        
        for (String key : genreMap.keySet()) {
            reverseGenreMap.put(genreMap.get(key) ,key);
        }
        
        List<Integer> playNumOfGenres = new ArrayList<>();
        for (Integer key : reverseGenreMap.keySet()) {
            playNumOfGenres.add(key);
        }
        playNumOfGenres.sort(Comparator.reverseOrder());
        
        List<Integer> answerList = new ArrayList<>();
        for (Integer playNum : playNumOfGenres) {
            Map<Integer, Integer> map = playMap.get(reverseGenreMap.get(playNum));
            List<Integer> bestAlbumList = new ArrayList<>();
            
            for (Integer key : map.keySet()) {
                if (bestAlbumList.size() == 0) {
                    bestAlbumList.add(key);
                } else if (bestAlbumList.size() == 1) {
                    if (map.get(bestAlbumList.get(0)) < map.get(key)) {
                        bestAlbumList.add(0, key);
                    } else {
                        bestAlbumList.add(key);
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        if (map.get(bestAlbumList.get(i)) < map.get(key)) {
                            bestAlbumList.add(i, key);
                            bestAlbumList.remove(2);
                            break;
                        }
                    }
                }
            }
            answerList.addAll(bestAlbumList);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
