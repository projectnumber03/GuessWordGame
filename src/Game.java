public class Game {
    private String[] words = {"компьютер", "клавиатура", "программист"}; //список слов
    private int lifes = 15; //количество жизней
    private char[] word; //выбранное слово
    private char[] g_word; //угадываемое слово
    private boolean isAlive; //статус игры

    public boolean isAlive() {
        return isAlive;
    }

    public Game() {
        this.isAlive = true;
        this.word = words[(int)Math.round(Math.random() * (words.length - 1))].toCharArray();
        this.g_word = new char[word.length];
        for (int i = 0; i < g_word.length; i++){
            g_word[i] = '-';
        }
        printArray(g_word);
    }

    public void play(String letter){
        if (lifes > 1 && containsLetter(g_word, "-")){
            try {
                if(containsLetter(word, letter)){
                    for (int i = 0; i < word.length; i++){
                        if(word[i] == letter.charAt(0)){
                            g_word[i] = letter.charAt(0);
                        }
                    }
                    printArray(g_word);
                    if(lifes > 0 && !containsLetter(g_word, "-")){
                        System.out.print("Вы отгадали слово - ");
                        printArray(word);
                        isAlive = false;
                    }
                } else {
                    lifes--;
                    System.out.println("Нет такой буквы. Осталось жизней: " + lifes);
                    printArray(g_word);
                }
            }catch (Exception e){
                System.out.println("Буква введена некорректно");
            }
        }else {
            System.out.print("Игра окончена, загаданное слово - ");
            printArray(word);
            isAlive = false;
        }
    }

    public boolean containsLetter(char[] word, String letter){
        return new String(word).contains(letter);
    }
    public void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
