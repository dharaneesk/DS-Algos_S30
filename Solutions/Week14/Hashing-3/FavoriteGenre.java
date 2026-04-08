// Time Complexity : O(user*songs)
// Space Complexity : O(songs)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// convert the existing <genre-songs> map to <song-genre> to get O(1) search
// iterate throught each user songs and find the freqCount of each genre and find max
// take the max count genres and add it to the user list

public class FavoriteGenre {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
            Map<String, List<String>> genreMap) {

        Map<String, String> songMap = new HashMap();
        Map<String, List<String>> result = new HashMap<>();
        Map<String, Integer> freqMap;
        int max = 0;

        for (String genre : genreMap.keySet()) {
            for (String song : genreMap.get(genre))
                songMap.put(song, genre);
        }

        for (String user : userMap.keySet()) {
            result.put(user, new ArrayList<>());
            freqMap = new HashMap<>();
            max = 0;
            for (String song : userMap.get(user)) {
                String genre = songMap.get(song);
                freqMap.put(genre, freqMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, freqMap.get(genre));
            }

            for (String genre : freqMap.keySet()) {
                if (freqMap.get(genre) == max)
                    result.get(user).add(genre);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));

        userSongs.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));

        songGenres.put("Dubstep", Arrays.asList(new String[] { "song7" }));

        songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));

        songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));

        songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
    }

}