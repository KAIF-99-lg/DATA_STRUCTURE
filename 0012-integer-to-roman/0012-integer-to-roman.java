class Solution {
    public String intToRoman(int num) {
        // Define values and corresponding Roman numerals
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        
        // Loop through the values array and build the Roman numeral
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(romanNumerals[i]);
            }
        }
        
        return result.toString();
    }
}
