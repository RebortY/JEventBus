/*
 * Copyright (C) 2012 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eb.eventbus;

import java.lang.reflect.Method;

import control.annotation.TagType;
import control.annotation.TargetMethod;

final class SubscriberMethod {
    final Method method;
    final ThreadMode threadMode;
    final Class<?> eventType;
    /** Used for efficient comparison */
    String methodString;
    TargetMethod target = null;
    TagType tagtype = null;

    SubscriberMethod(TargetMethod target) {
    	this.target = target;
        this.method = target.method;
        this.threadMode = target.threadMode;
        this.eventType = target.eventType;
        this.tagtype = target.type;
    }

    @Override
    public boolean equals(Object other) {
    	if(other instanceof SubscriberMethod){
    		SubscriberMethod otherSubscriberMethod = (SubscriberMethod)other;
    		return tagtype.equals(otherSubscriberMethod.tagtype);
    	}
    	return false;
//        if (other instanceof SubscriberMethod) {
//            checkMethodString();
//            SubscriberMethod otherSubscriberMethod = (SubscriberMethod)other;
//            otherSubscriberMethod.checkMethodString();
//            // Don't use method.equals because of http://code.google.com/p/android/issues/detail?id=7811#c6
//            return methodString.equals(otherSubscriberMethod.methodString);
//        } else {
//            return false;
//        }
    }

//    private synchronized void checkMethodString() {
//        if (methodString == null) {
//            // Method.toString has more overhead, just take relevant parts of the method
//            StringBuilder builder = new StringBuilder(64);
//            builder.append(method.getDeclaringClass().getName());
//            builder.append('#').append(method.getName());
//            builder.append('(').append(eventType.getName());
//            methodString = builder.toString();
//        }
//    }

    @Override
    public int hashCode() {
//        return method.hashCode();
    	return tagtype.hashCode();
    }
}