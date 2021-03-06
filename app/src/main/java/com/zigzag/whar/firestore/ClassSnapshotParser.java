package com.zigzag.whar.firestore;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.DocumentSnapshot;
import com.zigzag.whar.common.firebase.Preconditions;

/**
 * An implementation of {@link SnapshotParser} that converts {@link DocumentSnapshot} to
 * a class using {@link DocumentSnapshot#toObject(Class)}.
 */
public class ClassSnapshotParser<T> implements SnapshotParser<T> {

    private final Class<T> mModelClass;

    public ClassSnapshotParser(@NonNull Class<T> modelClass) {
        mModelClass = Preconditions.checkNotNull(modelClass);
    }

    @NonNull
    @Override
    public T parseSnapshot(@NonNull DocumentSnapshot snapshot) {
        return snapshot.toObject(mModelClass);
    }

}
