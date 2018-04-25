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

fun Value.getAnyValue(): kotlin.Any? {
    return when (kindCase ?: Value.KindCase.NULL_VALUE) {
        Value.KindCase.NULL_VALUE -> null
        Value.KindCase.NUMBER_VALUE -> numberValue
        Value.KindCase.STRING_VALUE -> stringValue
        Value.KindCase.BOOL_VALUE -> boolValue
        Value.KindCase.STRUCT_VALUE -> structValue
        Value.KindCase.LIST_VALUE -> listValue
        Value.KindCase.KIND_NOT_SET -> null
    }
}

fun Struct.fieldsMapToAny(): Map<String, kotlin.Any?> {
    return fieldsMap.mapValues { (_, value) ->  value.getAnyValue()}
}