<template>
    <div>
        <navigation />

        <div class="content">
            <router-view></router-view>
        </div>

        <alerts-emitter />
        <page-loader />
    </div>
</template>

<script>
    import Navigation from './navigation.vue';
    import PageLoader from './page-loader.vue';
    import AlertsEmitter from './alert-emitter.vue';

    export default {
        //
        // LOCAL COMPONENTS
        //
        components: {
            Navigation,
            PageLoader,
            AlertsEmitter
        }
    }
</script>

<style>
</style>
