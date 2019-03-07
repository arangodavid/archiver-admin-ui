<template>
    <div class="z-level7">
        <div class="slds-backdrop slds-backdrop_open"></div>

        <section class="slds-modal slds-fade-in-open">
            <div class="slds-modal__container">

                <header class="slds-modal__header">
                    <button @click="close" class="slds-button slds-button_icon slds-modal__close slds-button_icon-inverse" title="Close">
                        <icon icon="times" class="slds-button__icon slds-button__icon_large" />
                    </button>

                    <h2 class="slds-text-heading_medium">
                        <slot name="header"></slot>
                    </h2>
                </header>

                <div class="slds-modal__content">
                    <slot></slot>
                </div>

            </div>
        </section>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faTimes} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faTimes);

    export default {
        //
        // METHODS
        //
        methods: {
            close() {
                this.$emit('close');
            }
        }
    }
</script>

<style scoped>

</style>
