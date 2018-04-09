package es.lifk.protobufextensions

import com.google.protobuf.Any
import com.google.protobuf.Struct
import com.google.protobuf.Value

object WellKnownTypesBuilders {
    inline fun Any(block: Any.Builder.() -> Unit) = Any.newBuilder().apply(block).build()
    inline fun Struct(block: Struct.Builder.() -> Unit) = Struct.newBuilder().apply(block).build()
    inline fun Value(block: Value.Builder.() -> Unit) = Value.newBuilder().apply(block).build()
}

fun Any.copy(block: Any.Builder.() -> Unit) = this.toBuilder().apply(block).build()
fun Struct.copy(block: Struct.Builder.() -> Unit) = this.toBuilder().apply(block).build()
fun Value.copy(block: Value.Builder.() -> Unit) = this.toBuilder().apply(block).build()