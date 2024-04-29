public class AVLTree implements IBinaryTree<Student> {
    private AVLNode root = null;
    
    private enum Direction {
        Left,
        Right
    }
    
    // remove node holding the specified key from the tree, returns true if found, false otherwise
    public boolean remove(int key) {
        // search for the key
        AVLNode btn = search(key);
        
        // if not found
        if (btn == null) {
            // return false    
            return false;
        // else
        } else {
            if (btn.left == null && btn.right == null) {  // remove a leaf
                if (btn == root) {
                    root = null;
                } else {
                    if (btn.parent.left == btn) {
                        btn.parent.left = null;
                    } else {
                        btn.parent.right = null;
                    }
                    resetAncestorHeights(btn.parent);
                }
            } else if ((btn.left == null & btn.right != null) ||
                       (btn.left != null & btn.right == null)) {  // remove a node with one child
                if (btn == root) {
                    if (btn.left == null) {
                        root = root.right;
                    } else {
                        root = root.left;
                    }
                    root.parent = null;
                    resetAncestorHeights(root);
                } else {
                    if (btn.parent.left == btn) {
                        if (btn.left == null) {
                            btn.parent.left = btn.right;
                            btn.right.parent = btn.parent;
                        } else {
                            btn.parent.left = btn.left;
                            btn.left.parent = btn.parent;
                        }
                    } else {
                        if (btn.left == null) {
                            btn.parent.right = btn.right;
                            btn.right.parent = btn.parent;
                        } else {
                            btn.parent.right = btn.left;
                            btn.left.parent = btn.parent;
                        }
                    }
                    resetAncestorHeights(btn.parent);
                }
            } else {  // remove a node with both children
                // find left-most node on right child
                AVLNode currentNode = btn.right;
                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }

                btn.data = currentNode.data;  // copy the data from the left-most node into the node being deleted

                if (currentNode == btn.right) { // the right node WAS the left-most node
                    currentNode.parent.right = currentNode.right;
                    if (currentNode.right != null) {
                        currentNode.right.parent = currentNode.parent;
                    }
                    resetAncestorHeights(btn);
                } else if (currentNode.right != null) { // left-most node has a right component
                    currentNode.parent.left = currentNode.right; // so move it into the left-most
                    currentNode.right.parent = currentNode.parent; // node's position
                    resetAncestorHeights(currentNode.parent);
                } else { // left-most node has no children, so get rid of it
                    currentNode.parent.left = null;
                    resetAncestorHeights(currentNode.parent);
                }
            }
        }
        
        // Here is where we save directions to determine if an imbalance case is
        // Left-Left, Right-Right, Left-Right, or Right-Left.
        Direction[] dirs = new Direction[2];
        
        AVLNode currentNode = btn;

        while (currentNode.parent != null) {
            int bf = getBalanceFactor(currentNode);
            if (bf >= 2 || bf <= -2) {                // if we determine we are unbalanced,
                AVLNode unbalancedNode = currentNode;
                // if left is null, go right
                if (currentNode.left == null) {
                    dirs[0] = Direction.Right;
                    currentNode = currentNode.right;
                    if (currentNode.left == null) {
                        dirs[1] = Direction.Right;
                    } else if (currentNode.right == null) {
                        dirs[1] = Direction.Left;
                    } else if (currentNode.left.height > currentNode.right.height) {
                        dirs[1] = Direction.Left;
                    } else {
                        dirs[1] = Direction.Right;
                    }
                // if right is null, go left
                } else if (currentNode.right == null) {
                    dirs[0] = Direction.Left;
                    currentNode = currentNode.left;
                    if (currentNode.left == null) {
                        dirs[1] = Direction.Right;
                    } else if (currentNode.right == null) {
                        dirs[1] = Direction.Left;
                    } else if (currentNode.left.height > currentNode.right.height) {
                        dirs[1] = Direction.Left;
                    } else {
                        dirs[1] = Direction.Right;
                    }
                // neither are null so go left if left is higher
                } else if (currentNode.left.height > currentNode.right.height) {
                    dirs[0] = Direction.Left;
                    currentNode = currentNode.left;
                    if (currentNode.left == null) {
                        dirs[1] = Direction.Right;
                    } else if (currentNode.right == null) {
                        dirs[1] = Direction.Left;
                    } else if (currentNode.left.height > currentNode.right.height) {
                        dirs[1] = Direction.Left;
                    } else {
                        dirs[1] = Direction.Right;
                    }
                // neither are null so go right since right is higher
                } else {
                    dirs[0] = Direction.Right;
                    currentNode = currentNode.right;
                    if (currentNode.left == null) {
                        dirs[1] = Direction.Right;
                    } else if (currentNode.right == null) {
                        dirs[1] = Direction.Left;
                    } else if (currentNode.left.height > currentNode.right.height) {
                        dirs[1] = Direction.Left;
                    } else {
                        dirs[1] = Direction.Right;
                    }
                }
                
                // start at the first unbalanced node, and fix the balances all the way back to the root
                while (unbalancedNode != null) {
                    AVLNode nextNode = unbalancedNode.parent;
                    if (Math.abs(getBalanceFactor(unbalancedNode)) >= 2) {
                        rebalanceTree(unbalancedNode, dirs);     // we rebalance here and then break, because
                    }
                    unbalancedNode = nextNode;
                }
                break;                                //we always want to rebalance closest to the new node
            } else {
                currentNode = currentNode.parent;
            }
        }

        return true;
    }
    
    // return the tree height
    public int height() {
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }
    
    // insert new values into the tree from an array
    public void insert(Student[] values) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }
    
    // insert a new value into the tree
    public void insert(Student value) {
        AVLNode node = new AVLNode(value);

        if (root == null) {
            root = node;
            node.height = 0;
        } else {
            attachToNode(root, node);
        }
        
        /* Check to see if the new node threw the tree off balance.  If
         * that happened, we want to fix the unbalanced ancestor closest to
         * the new node.  That will fix the tree. */
        
        // A tree with less than 2 height is always balanced.  A new
        // node that causes an imbalance must have a minimum depth of two.
        if (root.height < 2) {
            return;
        }
        
        // Here is where we save directions to determine if an imbalance case is
        // Left-Left, Right-Right, Left-Right, or Right-Left.
        Direction[] dirs = new Direction[2];
        
        AVLNode currentNode = node;
        if (currentNode.parent.right == currentNode) {    // seed our direction array with the
            dirs[0] = Direction.Right;                    // first parent of the new node
        } else {
            dirs[0] = Direction.Left;
        }
        currentNode = currentNode.parent;
        
        // the first time in, we are finishing the seeding with the new node's parent direction
        while (currentNode.parent != null) {
            dirs[1] = dirs[0];
            if (currentNode.parent.right == currentNode) {
                dirs[0] = Direction.Right;
            } else {
                dirs[0] = Direction.Left;
            }
            
            currentNode = currentNode.parent;            
            int bf = getBalanceFactor(currentNode);
            if (bf >= 2 || bf <= -2) {                // if we determine we are unbalanced,
                rebalanceTree(currentNode, dirs);     // we rebalance here and then break, because
                break;                                //we always want to rebalance closest to the new node
            }
        }
    }

    private void rebalanceTree(AVLNode node, Direction[] rebalanceDirections) {
        if (rebalanceDirections[0] == Direction.Left) {
            if (rebalanceDirections[1] == Direction.Left) {
                fixLeftLeft(node);
            } else {
                fixLeftRight(node);
            }
        } else {
            if (rebalanceDirections[1] == Direction.Left) {
                fixRightLeft(node);
            } else {
                fixRightRight(node);
            }
        }
    }
    
    private void rotateClockwise(AVLNode node) {
        AVLNode greatgrandparent = node.parent;
        AVLNode grandparent = node;
        AVLNode parent = node.left;
        AVLNode child = parent.left;

        AVLNode T1 = child.left;
        AVLNode T2 = child.right;
        AVLNode T3 = parent.right;
        AVLNode T4 = grandparent.right;
        
        if (greatgrandparent != null) {    // if the grandparent is not the root, set the greatgrandparent's proper child
            if (greatgrandparent.left == grandparent)
                greatgrandparent.left = parent;
            else
                greatgrandparent.right = parent;
        } else {    // if the grandparent is the root, reset the root to what will be the new root
            root = parent;
        }
        
        if (T3 != null) {
            T3.parent = grandparent;
        }
        grandparent.left = T3;
        parent.right = grandparent;
        parent.parent = grandparent.parent;
        grandparent.parent = parent;
        
        resetAncestorHeights(grandparent);
    }
    
    private void rotateCounterClockwise(AVLNode node) {
        AVLNode greatgrandparent = node.parent;
        AVLNode grandparent = node;
        AVLNode parent = node.right;
        AVLNode child = parent.parent;

        AVLNode T1 = grandparent.left;
        AVLNode T2 = parent.left;
        AVLNode T3 = child.left;
        AVLNode T4 = child.right;
        
        if (greatgrandparent != null) {    // if the grandparent is not the root, set the greatgrandparent's proper child
            if (greatgrandparent.left == grandparent)
                greatgrandparent.left = parent;
            else
                greatgrandparent.right = parent;
        } else {    // if the grandparent is the root, reset the root to what will be the new root
            root = parent;
        }
        
        if (T2 != null) {
            T2.parent = grandparent;
        }
        grandparent.right = T2;
        parent.left = grandparent;
        parent.parent = grandparent.parent;
        grandparent.parent = parent;
        
        resetAncestorHeights(grandparent);
    }
    
    private void fixLeftLeft(AVLNode node) {
        rotateClockwise(node);
    }
    
    private void fixLeftRight(AVLNode node) {
        rotateCounterClockwise(node.left);
        rotateClockwise(node);
    }
    
    private void fixRightLeft(AVLNode node) {
        rotateClockwise(node.right);
        rotateCounterClockwise(node);
    }
    
    private void fixRightRight(AVLNode node) {
        rotateCounterClockwise(node);
    }
    
    private int getBalanceFactor(AVLNode node) {
        int leftFactor;
        int rightFactor;
        
        if (node.left == null) {
            leftFactor = -1;
        } else {
            leftFactor = node.left.height;
        }

        if (node.right == null) {
            rightFactor = -1;
        } else {
            rightFactor = node.right.height;
        }
        
        return leftFactor - rightFactor;
    }
    
    // a method that hangs the new node off of the proper side of the current node
    // and recurses if the desired spot is not null
    private void attachToNode(AVLNode parent, AVLNode node) {
        if (node.data.studentId >= parent.data.studentId) {
            if (parent.right == null) {
                parent.right = node;
                node.parent = parent;
                node.height = 0;
                
                /* if we add a leaf to a node that has no other leaf, then we are increasing
                 * that node's height.  Once we do that, we must check to see if any other
                 * ancestors have had their heights change.  If we added the leaf to a node
                 * that already had another leaf, then we didn't change the node's height,
                 * so its, and all it's ancestors' heights will be unaffected. */
                if (parent.left == null) {
                    resetAncestorHeights(parent);
                }
            } else {
                attachToNode(parent.right, node);
            }
        } else {
            if (parent.left == null) {
                parent.left = node;
                node.parent = parent;
                node.height = 0;
                
                /* if we add a leaf to a node that has no other leaf, then we are increasing
                 * that node's height.  Once we do that, we must check to see if any other
                 * ancestors have had their heights change.  If we added the leaf to a node
                 * that already had another leaf, then we didn't change the node's height,
                 * so its, and all it's ancestors' heights will be unaffected. */
                if (parent.right == null) {
                    resetAncestorHeights(parent);
                }
            } else {
                attachToNode(parent.left, node);
            }
        }
    }

    // reset the height of the specified node, and all its ancestors
    private void resetAncestorHeights(AVLNode node) {
        AVLNode currentNode = node;

        while (currentNode != null) {
            int leftHeight = -1;
            int rightHeight = -1;
            
            if (currentNode.left != null) {
                leftHeight = currentNode.left.height;
            }
            
            if (currentNode.right != null) {
                rightHeight = currentNode.right.height;
            }
            
            currentNode.height = Math.max(leftHeight, rightHeight) + 1;
            
            if (currentNode == root) {
                return;
            } else {
                currentNode = currentNode.parent;
            }
        }
    }

    // find the key in the tree, returning its tree node, or null if it is not found
    public AVLNode search(int key) {
        AVLNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.studentId == key) {
                return currentNode;
            } else {
                if (key < currentNode.data.studentId) {
                    if (currentNode.left == null) {
                        return null;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        return null;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        
        return null;
    }
    
    // print the tree vertically, one Student per line, in breadth-first mode
    public void print() {
        if (root == null) System.out.println("There are no nodes in the tree.");
        
        // build a queue of Students to enable breadth-first printing
        StudentQueue queue = new StudentQueue();
        AVLNode currentNode = root;
        while (currentNode != null) {
            // if there is a left node, add it to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            // if there is a right node, add it to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            
            // print the node
            Student student = currentNode.data;
            student.print();
            
            // end the loop when we're out of students
            if (queue.length() == 0) {
                currentNode = null;
            } else {
                currentNode = queue.next();
            }
        }
    }
}

 
