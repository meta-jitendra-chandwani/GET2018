#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct StackNode
{
	int data;
	struct StackNode* next;
};

struct StackNode* newNode(int data)
{
	struct StackNode* stackNode =
			(struct StackNode*) malloc(sizeof(struct StackNode));
	stackNode->data = data;
	stackNode->next = NULL;
	return stackNode;
}

int isEmpty(struct StackNode *root)
{
	return !root;
}

void Push(struct StackNode** root, int data)
{
	struct StackNode* stackNode = newNode(data);
	stackNode->next = *root;
	*root = stackNode;
	printf("%d pushed to stack\n", data);
}

int PoP(struct StackNode** root)
{
	if (isEmpty(*root))
		return INT_MIN;
	struct StackNode* temp = *root;
	*root = (*root)->next;
	int popped = temp->data;
	free(temp);
	return popped;
}

int Top(struct StackNode* root)
{
	if (isEmpty(root))
		return INT_MIN;
	return root->data;
}

int main()
{
	struct StackNode* root = NULL;
	Push(&root, 10);
	Push(&root, 20);
	Push(&root, 30);
	printf("%d popped from stack\n", PoP(&root));
	printf("Top element is %d\n", Top(root));
	return 0;
}