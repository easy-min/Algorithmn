class Solution {
    static char[] skills;
    public int solution(String skill, String[] skill_trees) {
        skills = skill.toCharArray(); // 저장
        int ans = 0;
        for (int i = 0; i<skill_trees.length; i++){
            // 하나의 스킬셋씩 차근차근 보자
            Stack<Character> stack = new Stack<>(); // skill_set
            boolean isAns = true;
            for (int j = 0; j<skill_trees[i].length() && isAns; j++){
                char target = skill_trees[i].charAt(j);
                char target_wanted = hasPreviousSkill(target);
                if (target_wanted!='x'){
                    // skill_set에 있고 이전 스킬이 필요함!
                    boolean find_target_wanted = false;
                    while(!stack.isEmpty()){ // 스택에서 꺼내 확인해보자
                        if (stack.pop()==target_wanted){
                            find_target_wanted = true;
                            stack.push(target);
                            break;
                        }
                    }
                    if (!find_target_wanted){
                        isAns = false;
                    }
                } else {
                    stack.push(target);
                }
            }
            if (isAns) ans++;
        }

        return ans;
    }
    static char hasPreviousSkill(char target){
        for (int i = 1; i < skills.length; i++) { // 첫번째는 노상관
            if (skills[i] == target){
                return skills[i-1];
            }
        }
        return 'x'; // 문제에서 스킬셋은 모두 대문자임
    }
}