package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

//톱니바퀴 문제

public class ForStudy {
	//Deque는 index접근이 앞 끝 만 되고
	//비슷하게 LinkedList는 인덱스별 접근가능!! 이게 제일 좋은거 같다.
	static LinkedList<Integer> q[] = new LinkedList[5];
	

	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//톱니바퀴 완성
		for(int i=1;i<5;i++)
		{
			q[i]=new LinkedList<>();
			String s[]= bf.readLine().split("");
			for(int j=0;j<s.length;j++)
			{
				q[i].offer(Integer.parseInt(s[j]));
			}
		}
		int num= Integer.parseInt(bf.readLine());
		
		for(int i=0;i<num;i++)
		{
			String st[]=bf.readLine().split(" ");
			
			int qNum=Integer.parseInt(st[0]);
			int qDir=Integer.parseInt(st[1]);
			leftCheck(qNum-1, qDir);
			rightCheck(qNum+1, qDir);
			turnQ(qNum,qDir);
		}
		int sum=0;
		sum=q[1].get(0)+(q[2].get(0)*2)+(q[3].get(0)*4)+(q[4].get(0)*8);
		System.out.println(sum);
		
	} //main끝
	public static void turnQ(int qNum,int qDir)
	{
		if(qDir==1)
		{
			//마지막녀석을 삭제하고 첫번째로 들어감
			//12345-> 5삭제하고->51234x 질문! x는 어떻게 되는거지?생각할 필요없는건가?
			q[qNum].addFirst(q[qNum].pollLast());
		}
		if(qDir==-1)
		{
			q[qNum].addLast(q[qNum].pollFirst());
		}
	}
	
	
	//입력된 qNum의 왼쪽이 파라미터로 넘어옴, qNum이 돌았던 방향을 넘김
	//여기서 qNum은 입력된 qNum-1 , qDir은 입력된 qDir방향 그대로
	public static void leftCheck(int qNum,int qDir)
	{
		if(qNum<1||4<qNum){return ;}
		if(q[qNum].get(2)!=q[qNum+1].get(6))
		{
			turnQ(qNum,-qDir);
			leftCheck(qNum-1, -qDir);
		}
	}
	
	//입력된 qNum의 오른쪽이 파라미터로 넘어옴, qNum이 돌았던 방향을 넘김
	//여기서 qNum은 입력된 qNum+1 , qDir은 입력된 qDir방향 그대로
	public static void rightCheck(int qNum,int qDir)
	{
		if(qNum<1||4<qNum){return ;}
		if(q[qNum].get(6)!=q[qNum-1].get(2))
		{
			turnQ(qNum,-qDir);
			rightCheck(qNum+1, -qDir);
		}
	}

}//class끝
