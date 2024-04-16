class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> frequencies;

    TrieNode() {
        children = new HashMap<>();
        frequencies = new HashMap<>();
    }
}

class AutoCompleteSystem {
    private TrieNode root;
    private TrieNode current;
    private StringBuilder currentQuery;

    AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        current = root;
        currentQuery = new StringBuilder();

        for (int i = 0; i < sentences.length; ++i) {
            insert(sentences[i], times[i]);
        }
    }

    void insert(String sentence, int time) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.frequencies.put(sentence, node.frequencies.getOrDefault(sentence, 0) + time);
        }
    }

    List<String> input(char c) {
        if (c == '#') {
            insert(currentQuery.toString(), 1);
            currentQuery.setLength(0);
            current = root;
            return new ArrayList<>();
        }

        currentQuery.append(c);
        if (!current.children.containsKey(c)) {
            current.children.put(c, new TrieNode());
            current = current.children.get(c);
            return new ArrayList<>();
        }

        current = current.children.get(c);
        List<Map.Entry<String, Integer>> suggestions = new ArrayList<>(current.frequencies.entrySet());
        suggestions.sort((a, b) -> (b.getValue() != a.getValue()) ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey()));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, suggestions.size()); ++i) {
            result.add(suggestions.get(i).getKey());
        }

        return result;
    }
}
