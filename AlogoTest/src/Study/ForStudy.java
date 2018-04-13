package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

//��Ϲ��� ����

public class ForStudy {
	//Deque�� index������ �� �� �� �ǰ�
	//����ϰ� LinkedList�� �ε����� ���ٰ���!! �̰� ���� ������ ����.
	static LinkedList<Integer> q[] = new LinkedList[5];
	

	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//��Ϲ��� �ϼ�
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
		
	} //main��
	public static void turnQ(int qNum,int qDir)
	{
		if(qDir==1)
		{
			//�������༮�� �����ϰ� ù��°�� ��
			//12345-> 5�����ϰ�->51234x ����! x�� ��� �Ǵ°���?������ �ʿ���°ǰ�?
			q[qNum].addFirst(q[qNum].pollLast());
		}
		if(qDir==-1)
		{
			q[qNum].addLast(q[qNum].pollFirst());
		}
	}
	
	
	//�Էµ� qNum�� ������ �Ķ���ͷ� �Ѿ��, qNum�� ���Ҵ� ������ �ѱ�
	//���⼭ qNum�� �Էµ� qNum-1 , qDir�� �Էµ� qDir���� �״��
	public static void leftCheck(int qNum,int qDir)
	{
		if(qNum<1||4<qNum){return ;}
		if(q[qNum].get(2)!=q[qNum+1].get(6))
		{
			turnQ(qNum,-qDir);
			leftCheck(qNum-1, -qDir);
		}
	}
	
	//�Էµ� qNum�� �������� �Ķ���ͷ� �Ѿ��, qNum�� ���Ҵ� ������ �ѱ�
	//���⼭ qNum�� �Էµ� qNum+1 , qDir�� �Էµ� qDir���� �״��
	public static void rightCheck(int qNum,int qDir)
	{
		if(qNum<1||4<qNum){return ;}
		if(q[qNum].get(6)!=q[qNum-1].get(2))
		{
			turnQ(qNum,-qDir);
			rightCheck(qNum+1, -qDir);
		}
	}

}//class��
