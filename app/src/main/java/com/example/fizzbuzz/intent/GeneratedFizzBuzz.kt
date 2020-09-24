package com.example.fizzbuzz.intent

import io.reactivex.disposables.Disposable

interface GeneratedFizzBuzz<T> {
    fun onError(e : Throwable)
    fun onComplete()
    fun onNext(t : T)
    fun onSubscribe(d: Disposable)
}