#include <jni.h>
#include <string>

struct SinglyLinkedListNode {
     int data;
     SinglyLinkedListNode* next;
};

extern "C" JNIEXPORT jstring JNICALL
Java_com_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_myapplication_MainActivity_intFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    int i;
    for(i = 0; i< 10; i++)
        i++;
    std::string h = std::to_string(i);
    return env->NewStringUTF(h.c_str());
}

