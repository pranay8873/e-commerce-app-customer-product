package com.java.ecommerce.service;


    class Solution {
        // You are given two arrays of strings wordsContainer and wordsQuery.
        //
        //For each wordsQuery[i], you need to find a string from wordsContainer that has the longest common suffix with wordsQuery[i]. If there are two or more strings in wordsContainer that share the longest common suffix, find the string that is the smallest in length. If there are two or more such strings that have the same smallest length, find the one that occurred earlier in wordsContainer.
        //
        //Return an array of integers ans, where ans[i] is the index of the string in wordsContainer that has the longest common suffix with wordsQuery[i].

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int bestIndex = -1; // Stores the index of the best matching word in wordsContainer
        }

        TrieNode root = new TrieNode();
        String[] wordsContainer;

        private void insert(int index) {
            String word = wordsContainer[index];
            TrieNode curr = root;

            // Helper logic to check if 'index' is a better choice than 'currentIndex'
            if (isBetter(index, root.bestIndex)) {
                root.bestIndex = index;
            }

            // Insert from right to left (simulating a reversed string)
            for (int i = word.length() - 1; i >= 0; i--) {
                int charIdx = word.charAt(i) - 'a';
                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] = new TrieNode();
                }
                curr = curr.children[charIdx];

                // Update the node's best index if this word is shorter,
                // or same length but appeared earlier
                if (isBetter(index, curr.bestIndex)) {
                    curr.bestIndex = index;
                }
            }
        }

        private boolean isBetter(int newIndex, int oldIndex) {
            if (oldIndex == -1) return true;

            int newLen = wordsContainer[newIndex].length();
            int oldLen = wordsContainer[oldIndex].length();

            if (newLen < oldLen) return true;
            if (newLen == oldLen && newIndex < oldIndex) return true;

            return false;
        }

        private int search(String query) {
            TrieNode curr = root;
            // Search from right to left (simulating a reversed string)
            for (int i = query.length() - 1; i >= 0; i--) {
                int charIdx = query.charAt(i) - 'a';
                if (curr.children[charIdx] == null) {
                    break; // No further common suffix found
                }
                curr = curr.children[charIdx];
            }
            // Return the pre-calculated best index for this suffix length
            return curr.bestIndex;
        }

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            this.wordsContainer = wordsContainer;

            // Build the Trie
            for (int i = 0; i < wordsContainer.length; i++) {
                insert(i);
            }

            // Process queries
            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                ans[i] = search(wordsQuery[i]);
            }

            return ans;
        }
    }

