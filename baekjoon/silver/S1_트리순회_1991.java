package _0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_트리순회_1991 {
	static node[] tree;

	static class node {
		node(char value) {
			this.value = value;
		}

		node left;
		node right;
		char value;
	}

	static void preorder(node cNode) {
		if (cNode == null || cNode.value == '.')
			return;
		System.out.print(cNode.value);
		preorder(cNode.left);
		preorder(cNode.right);
	}

	static void inorder(node cNode) {
		if (cNode == null || cNode.value == '.')
			return;
		inorder(cNode.left);
		System.out.print(cNode.value);
		inorder(cNode.right);
	}

	static void postorder(node cNode) {
		if (cNode == null || cNode.value == '.')
			return;
		postorder(cNode.left);
		postorder(cNode.right);
		System.out.print(cNode.value);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		tree = new node[27];
		int treeidx = 1;
		tree[treeidx++] = new node('A'); // head

		for (int i = 0; i < N; i++) {
			node currentNode = null;
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			char nodeval = stk.nextToken().charAt(0);
			for (int j = 1; j < 27; j++) {
				if (tree[j].value == nodeval) {
					currentNode = tree[j];
					break;
				}
			}
			char c = stk.nextToken().charAt(0);
			node child = new node(c);
			if (c != '.')
				tree[treeidx++] = child;
			currentNode.left = child;

			c = stk.nextToken().charAt(0);
			child = new node(c);
			if (c != '.')
				tree[treeidx++] = child;
			currentNode.right = child;
		}

		preorder(tree[1]);
		System.out.println();
		inorder(tree[1]);
		System.out.println();
		postorder(tree[1]);
	}

}
