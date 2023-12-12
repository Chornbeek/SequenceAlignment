Customizable Alignment Scoring:

-The scoring system differentiates between vowels, consonants, and mismatches.
-Scores can be assigned for matching characters, vowel-vowel mismatches, consonant-consonant mismatches, and vowel-consonant mismatches.

Dynamic Programming Approach:

-Utilizes a matrix (A) to store the cost of alignments at each step.
-Employs dynamic programming for efficient computation of the optimal alignment.

Flexible and Extensible:

-The alignment scoring parameters can be adjusted easily.
-Supports any string input for alignment.

Public Methods
-SequenceAlignment(String string1, String string2): Constructor to initialize the sequences to be aligned.
-computeAlignment(int delta): Computes the optimal alignment between the two strings, where delta is the gap penalty.
-getAlignment(): Returns the optimal alignment as a string, showing the two aligned sequences with gaps if necessary.
-Scoring System
-sameSymbol: Score for matching characters.
-vowelDiffVow: Penalty for mismatch between two vowels.
-consDiffCons: Penalty for mismatch between two consonants.
-vowelDiffCons: Penalty for mismatch between a vowel and a consonant.
